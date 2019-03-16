#ifndef XNAY_H_INCLUDED
#define XNAY_H_INCLUDED

#include <iostream>
#include <cmath> // za funkciju pow

using namespace std;

class XnaY {
    private:
        int x,y;
    public:
        XnaY();
        XnaY(int, int);
        XnaY(const XnaY&);

        // set metode
        void setX(int);
        void setY(int);
        void setX_Y(int,int);

        // get metode
        int getX() const;
        int getY() const;
        double getXnaY() const;
};

#endif // XNAY_H_INCLUDED
