#include "computer.hpp"

Computer::Computer()
{
    hddGB = 500;
    ramGB = 8;
    gCard = "Nvidia GeForce GTX 970 or equal";
    os = "Win7";
}

Computer::Computer(double h, double r, const char* g, const char* o)
{
    hddGB = h;
    ramGB = r;
    gCard = g;
    os = o;
}

Computer::Computer(const Computer& c)
{
    hddGB = c.hddGB;
    ramGB = c.ramGB;
    gCard = c.gCard;
    os = c.os;
}

ostream& operator<<(ostream &out, const Computer &c)
{
    out << "HDD [GB]: " << c.hddGB << endl;
    out << "RAM [GB]: " << c.ramGB << endl;
    out << "Graphical card: " << c.gCard << endl;
    out << "Operative system: " << c.os << endl;
    return out;

}

