#include <iostream>
#include <iomanip>

#include "valjak.hpp"

using namespace std;



int main()
{
    cout << fixed << setprecision(2);

    Krug k1;
    Krug k2(3);
    cout << "k1: P = " << k1.getP() << ", O = " << k1.getO() << endl;
    cout << "k2: P = " << k2.getP() << ", O = " << k2.getO() << endl << endl;


    Pravougaonik p1;
    Pravougaonik p2(1,8);
    cout << "p1: P = " << p1.getP() << ", O = " << p1.getO() << endl;
    cout << "p2: P = " << p2.getP() << ", O = " << p2.getO() << endl << endl;

    Valjak v1;
    Valjak v2(2,4);
    cout << "v1: P = " << v1.getP() << ", V = " << v1.getV() << endl;
    cout << "v2: P = " << v2.getP() << ", V = " << v2.getV() << endl << endl;

    return 0;
}
