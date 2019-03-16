#ifndef MENJAC_HPP_INCLUDED
#define MENJAC_HPP_INCLUDED

enum TipMenjaca { AUTOMATIK, MANUELNI };

class Menjac{
    private:
        TipMenjaca tip;
        int brzina;

    public:
        Menjac(){ tip = AUTOMATIK; brzina = 1;}
        Menjac(TipMenjaca t, int b) { tip = t; brzina = b;}
        Menjac(const Menjac& m) { tip = m.tip; brzina = m.brzina;}

        bool setBrzina(int b){
            if (b >= 1 && b <= 6){
                brzina = b;
                return true;
            }
            return false;
        }

        void setTip(TipMenjaca t) { tip = t; }
        int getBrzina() const { return brzina;}
        TipMenjaca getTip() const { return tip;}

        friend void ispisiMenjac(const Menjac&); // prijateljska funkcija

};


#endif // MENJAC_HPP_INCLUDED
