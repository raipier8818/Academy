#include <curses.h>
#include <iostream>

#include "screen.hpp"
#include "utility.hpp"


int main() {
    size_t height, width;
    std::cin >> height >> width;

    Screen screen{ height, width };

    char c = 0;
    bool flag = true;
    while (flag) {
        screen.draw(std::cout);
        std::cin >> c;
        switch (c) {
            case Key::UP:
                /*
                screen.rotateLeft(1,height,width);
                screen.move(height,width);
                screen.rotateLeft(3,height,width);
                */
                screen.up();
                screen.create();
                break;
            case Key::DOWN:
                /*
                screen.rotateLeft(3,height,width);
                screen.move(height,width);
                screen.rotateLeft(1,height,width);
                */
                screen.down();
                screen.create();
                break;
            case Key::LEFT:
                //screen.move(height,width);
                screen.left();
                
                screen.create();
                break;
            case Key::RIGHT:
                /*
                screen.rotateLeft(2,height,width);
                screen.move(height,width);
                screen.rotateLeft(2,height,width);
                */
                screen.right();
                screen.create();
                break;
            default:
                flag = false;
                break;
        }

        if(screen.checkEnd()){
            screen.draw(std::cout);
            std::cout << screen.Score() << std::endl;
            flag = false;
        }
    };
    std::cout << screen.Score() << std::endl;
}
