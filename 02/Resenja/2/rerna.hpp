#ifndef RERNA_H_INCLUDED
#define RERNA_H_INCLUDED

#include <iostream>
using namespace std;

#define TEMPERATURA_MINIMUM 0
#define TEMPERATURA_MAKSIMUM 220
#define TEMPERATURA_KORAK 20

enum StanjeRerne {ISKLJUCENA, UKLJUCENA, POKVARENA};

class Rerna{
    private:
        StanjeRerne trenutnoStanje;
        int temperatura;
    public:

        Rerna();

        bool ukljuci();
        bool iskljuci();
        bool pokvari();
        bool popravi();

        bool pojacajTemperaturu();
        bool smanjiTemperaturu();

        StanjeRerne getTrenutnoStanje() const;

        int getTemperatura() const;
};

#endif // RERNA_H_INCLUDED

