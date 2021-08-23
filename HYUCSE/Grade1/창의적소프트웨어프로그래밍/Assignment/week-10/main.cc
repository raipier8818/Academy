#include <iostream>
#include <string>
#include "shape.h"

int main() {
    size_t x, y, w, h;

    std::cin >> w >> h;
    Canvas canvas{h, w};

    while (true)
    {
        std::string DO;
        std::cin >> DO;
        if(DO == "exit") break;
        std::string G;
        if(DO == "add"){
            std::cin >> G;
            if(G == "point"){
                std::cin >> x >> y;
                Point* p = new Point;
                p->set_offset({x,y});
                std::cout << canvas.add(p) << "\n";
            }
            else if(G == "rectangle"){
                //std::cout << "---";
                std::cin >> x >> y >> w >> h;
                Rectangle* r = new Rectangle({x,y},{w,h});
                
                std::cout << canvas.add(r) << "\n";
            }
            else if(G == "circle"){
                std::cin >> x >> y >> w;
                Circle* c = new Circle({x,y},w);
                std::cout << canvas.add(c) << "\n";
            }
            else if(G == "triangle"){
                std::cin >> x >> y >> w >> h;
                Triangle* t = new Triangle({x,y},{w,h});
                std::cout << canvas.add(t) << "\n";
            }
        }
        else if (DO == "draw"){
            canvas.draw();
        }
        else if (DO == "clear"){
            canvas.clear();
        }
        else if (DO == "set"){
            int id;
            std::string next;
            std::cin >> id >> next;
            if(next == "size"){
                //also need to make circle case
                std::cin >> w >> h;
                canvas.at_fillable(id)->set_size({w,h});
            }
            else if(next == "offset"){
                std::cin >> x >> y;
                canvas.at_drawable(id)->set_offset({x,y});
            }
            else if(next == "visible"){
                std::string TF;
                std::cin >> TF;
                if(TF == "true"){
                    canvas.at_drawable(id)->set_visible(true);
                }
                else canvas.at_drawable(id)->set_visible(false);

            }
            else if(next == "fill"){
                std::string TF;
                std::cin >> TF;
                if(TF == "true"){
                    canvas.at_fillable(id)->set_fill(true);
                }
                else canvas.at_fillable(id)->set_fill(false);

            }

        }


    }


    return 0;
}