'''
Created on Dec 25, 2018

@author: Marko
'''
from teretni_voz import TeretniVoz
from roba import Roba

if __name__ == '__main__':
    tv = TeretniVoz(3, 100)
    print(tv)
    print(tv.getMarkaNajtezeRobe())
    
    r, r2, r3 = Roba(), Roba("Adidas", "patike", 2), Roba("Adidas", "trenerka", 1)
    print(tv.utovariTeret(r, 1))
    print(tv.utovariTeret(r2, 2))
    print(tv.utovariTeret(r3, 2))
    print(tv)
    
    print(tv.getMarkaNajtezeRobe())
    print(tv.getSlobodanProstor(0));
    print(tv.getSlobodanProstor(1));
    print(tv.getSlobodanProstor(2));
    print(tv.getSlobodanProstor(3));