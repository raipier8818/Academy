#include <utility>
#include <vector>
#include <functional>
#include <iostream>
#include <cmath>

using Point_ = std::pair<float, float>;

class Drawable {
public:
    Drawable(Point_ offset = { 0, 0 }, bool visible = true)
        : offset(offset), visible(visible) {
    }

    virtual std::vector<Point_> draw() = 0;

    void set_offset(const Point_& offset) {
        this->offset = offset;
    }
    const Point_& get_offset() const {
        return offset;
    }

    void set_visible(bool visible = true) {
        this->visible = visible;
        //std::cout << this->visible << std::endl;
    }
    bool get_visible() const {
        return visible;
    }

private:
    bool visible;
    Point_ offset;
};

class Fillable {
public:
    Fillable(Point_ size, bool fill = true)
        : size(size), fill(fill) {
    }

    void set_fill(bool fill = true) {
        this->fill = fill;
    }
    bool get_fill() const {
        return fill;
    }

    void set_size(const Point_& size) {
        this->size = size;
    }
    const Point_& get_size() const {
        return size;
    }
private:
    bool fill;
    Point_ size;
};

class Point : public Drawable {
public:
    Point(Point_ offset = { 0, 0 }, bool visible = true)
        : Drawable(offset, visible) {
    }

    std::vector<Point_> draw() {
        //if(!get_visible()) return {};
        return { get_offset() };
    }
};

class Rectangle : public Drawable, public Fillable {
public:
    Rectangle(Point_ offset, Point_ size, bool fill = true, bool visible = true)
        : Drawable(offset, visible), Fillable(size, fill) {
    }

    

    std::vector<Point_> draw() {
        //if(!get_visible()) return {};
        std::vector<Point_> DrawPoints;

        float first_x = get_offset().first;
        float first_y = get_offset().second;
        float end_x = first_x + get_size().first-1;
        float end_y = first_y + get_size().second-1;

        for(int i = first_x; i <= end_x; i++){
            for(int j = first_y; j <= end_y; j++){
                if(i == first_x || i == end_x|| j == first_y || j == end_y){
                    DrawPoints.push_back(std::make_pair(i,j));
                }else{
                    if(get_fill()){
                        DrawPoints.push_back({i,j});
                    }
                }
            }
        }
        /*
        for(int i = 0; i < DrawPoints.size(); i++){
            std::cout << "--" << DrawPoints[i].first << ","  << DrawPoints[i].second << std::endl;
        }
        */
        return DrawPoints;
    }
};

class Circle : public Drawable, public Fillable {
public:
    Circle(Point_ offset, size_t size, bool fill = true, bool visible = true)
        : Drawable(offset, visible), Fillable({ size, size }, fill) {
    }
    std::vector<Point_> DrawPoints;

    std::vector<Point_> draw() {
        //if(!get_visible()) return {};

        float center_x = get_offset().first;
        float center_y = get_offset().second;
        float radius = get_size().first;

        // (x-center_x)^2 + (y-center_y)^2 = radius^2


        for(float i = center_y - radius;  i <= center_y + radius; i++){
            float left_x = round(-1*(sqrt(radius*radius - (i - center_y)*(i - center_y))) + center_x);
            float right_x = round(sqrt(radius*radius - (i - center_y)*(i - center_y)) + center_x);
            if(get_fill()){
                for(float j = left_x; j <= right_x; j++){
                    DrawPoints.push_back({j,i});
                }
            }
            else{
                DrawPoints.push_back({left_x,i});
                DrawPoints.push_back({right_x,i});
            }
        }

        return DrawPoints;        
    }
};

class Triangle : public Drawable, public Fillable {
public:
    Triangle(Point_ offset, Point_ size, bool fill = true, bool visible = true)
        : Drawable(offset, visible), Fillable(size, fill) {
    }
    std::vector<Point_> DrawPoints;

    std::vector<Point_> draw() {
        //if(!get_visible()) return {};

        float mid_x = get_offset().first;
        float mid_y = get_offset().second;
        float w = get_size().first;
        float h = get_size().second;

        float left_x = mid_x - w/2;
        float right_x = mid_x + w/2;
        //printf("%f %f // %f %f\n",left_x,right_x, std::round(left_x), std::round(right_x));

        float end_y = mid_y - h;


        for(float i = mid_y; i >= end_y; i--){
            float lx = round(mid_x - (w/2)*((i-end_y)/h));
            float rx = round(mid_x + (w/2)*((i-end_y)/h));
            //printf("%f %f // %f %f\n", lx,rx, std::round(lx), std::round(rx));

            if(i == mid_y){
                for(int j = lx; j <= rx; j++){
                    DrawPoints.push_back({j,i});
                    continue;
                }
            }

            if(get_fill())
            {
                for(float j = lx; j <= rx; j++){
                    DrawPoints.push_back({j,i});
                }
            }else{
                DrawPoints.push_back({lx,i});
                DrawPoints.push_back({rx,i});
            }

        }

        

        return DrawPoints;
    }
};

class Canvas {
public:
    Canvas(size_t row, size_t col, char ch = '*')
        : row(row), col(col), ch(ch), matrix(row, std::vector<bool>(col, false)) {
    }
    ~Canvas() {}

    void resize(size_t row, size_t col) {
        row = row;
        col = col;
    }

    size_t add(Point* drawable) {
        drawable_components.push_back(drawable);
        fillable_components.push_back(nullptr);

        return drawable_components.size() - 1;
    }

    template <typename T>
    size_t add(T fillable) {
        drawable_components.push_back(fillable);
        fillable_components.push_back(fillable);

        return drawable_components.size() - 1;
    }

    void draw() {
        //std::cout <<"drawing.." << std::endl;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                //std::cout << i << j << "\n";
                matrix[i][j] = false;
            }
        }
        
        for(int i = 0; i < drawable_components.size(); i++){
            std::vector <Point_> printPoint = drawable_components[i]->draw();
            for(int j = 0; j < printPoint.size(); j++){
                int x = printPoint[j].first - 1;
                int y = printPoint[j].second - 1;

                //std::cout << x << y << i << j << std::endl;

                if(x < 0 || x >= col || y < 0 || y >= row) continue;
                if(drawable_components[i]->get_visible() == false){
                    matrix[y][x] = false;
                }
                else{
                    matrix[y][x] = true;
                }
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j]) std::cout << get_ch();
                else std::cout << ".";
            }
            std::cout << "\n";
        }
    }

    void drawable_apply(const std::function<void(Drawable*)>& f) {
        for (auto component : drawable_components) {
            f(component);
        }
    }
    void fillable_apply(const std::function<void(Fillable*)>& f) {
        for (auto component : fillable_components) {
            f(component);
        }
    }

    void clear() {
        drawable_components.clear();
        fillable_components.clear();
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                //std::cout << i << j << "\n";
                matrix[i][j] = false;
            }
        }
        
    }

    void set_ch(char ch) {
        ch = ch;
    }
    char get_ch() const {
        return ch;
    }

    Drawable* at_drawable(size_t index) {
        return drawable_components[index];
    }
    Fillable* at_fillable(size_t index) {
        return fillable_components[index];
    }

private:
    size_t row, col;
    char ch;
    std::vector<Drawable*> drawable_components;
    std::vector<Fillable*> fillable_components;

    std::vector<std::vector<bool>> matrix;
};
