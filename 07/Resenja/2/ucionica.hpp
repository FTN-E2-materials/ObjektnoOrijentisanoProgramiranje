#ifndef UCIONICA_H_INCLUDED
#define UCIONICA_H_INCLUDED

#include "student.hpp"
#include "profesor.hpp"
#include "list.hpp"

class Ucionica{
private:
    List<Osoba> osobe;
    DinString naziv;
    int kapacitet;

public:
    Ucionica(const DinString& n, int k) : naziv(n), kapacitet(k) {}

    bool dodaj(const Osoba& os){
        if(osobe.size() < kapacitet){
            return osobe.add(osobe.size() + 1, os);
        }

        return false;
    }

    void ispis() const {
        if(osobe.size() == 0) {
            cout << endl << "Ucionica je prazna." << endl;
        } else {
            Osoba o;
            cout << endl << "U ucionici su:" << endl;

            for (int i = 1; i <= osobe.size(); i++){
                osobe.read(i, o);
                o.predstaviSe();
            }
        }
    }

};

#endif // UCIONICA_H_INCLUDED
