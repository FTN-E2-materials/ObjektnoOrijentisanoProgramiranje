#include "rerna.hpp"

Rerna::Rerna(){
    trenutnoStanje = ISKLJUCENA;
    temperatura = TEMPERATURA_MINIMUM;
}

bool Rerna::ukljuci(){
    bool uspesno;

    if (trenutnoStanje == ISKLJUCENA) {
        trenutnoStanje = UKLJUCENA;
        temperatura += TEMPERATURA_KORAK;
        uspesno = true;
    } else {
        uspesno = false;
    }

    return uspesno;
}

bool Rerna::iskljuci(){
    bool uspesno;

    if (trenutnoStanje == UKLJUCENA) {
        trenutnoStanje = ISKLJUCENA;
        temperatura = TEMPERATURA_MINIMUM;
        uspesno = true;
    } else {
        uspesno = false;
    }

    return uspesno;
}

bool Rerna::pokvari(){
    bool uspesno;

    if (trenutnoStanje != POKVARENA) {
        trenutnoStanje = POKVARENA;
        temperatura = TEMPERATURA_MINIMUM;
        uspesno = true;
    } else {
        uspesno = false;
    }

    return uspesno;
}

bool Rerna::popravi(){
    bool uspesno;

    if (trenutnoStanje == POKVARENA) {
        trenutnoStanje = ISKLJUCENA;
        temperatura = TEMPERATURA_MINIMUM;
        uspesno = true;
    } else {
        uspesno = false;
    }

    return uspesno;
}

bool Rerna::pojacajTemperaturu(){
    bool uspesno;

    if (trenutnoStanje == UKLJUCENA && temperatura + TEMPERATURA_KORAK <= TEMPERATURA_MAKSIMUM) {
        temperatura += TEMPERATURA_KORAK;
        uspesno = true;
    } else {
        uspesno = false;
    }

    return uspesno;
}

bool Rerna::smanjiTemperaturu(){
    bool uspesno;

    if (trenutnoStanje == UKLJUCENA && temperatura - TEMPERATURA_KORAK >= TEMPERATURA_MINIMUM) {
        temperatura -= TEMPERATURA_KORAK;
        uspesno = true;
    } else {
        uspesno = false;
    }

    return uspesno;
}

StanjeRerne Rerna::getTrenutnoStanje() const{
    return trenutnoStanje;
}

int Rerna::getTemperatura() const {
    return temperatura;
}



