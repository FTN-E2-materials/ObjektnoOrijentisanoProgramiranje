'''
Created on Dec 25, 2018

@author: Marko
'''

from vagon import Vagon
from roba import Roba

class TeretniVoz:

    def __init__(self, brVagona, maxDozvoljenoKG):
        self.vagoni = []
        while brVagona > 0:
            self.vagoni.append(Vagon())
            brVagona -= 1
        self.vagonMaxKG = maxDozvoljenoKG
        
    def getSlobodanProstor(self, brVagona):
        if type(brVagona) is not int: #NE MORA OVA PROVERA
            return -1
        if brVagona < 0 or brVagona >= len(self.vagoni):
            return -1
        return self.vagonMaxKG - self.vagoni[brVagona].getTezinaRobe()
    
    def utovariTeret(self, teret, brVagona):
        if type(teret) is not Roba: #NE MORA OVA PROVERA
            return False
        if type(brVagona) is not int: #NE MORA OVA PROVERA
            return False
        
        if brVagona < 0 or brVagona >= len(self.vagoni):
            return False
        if teret.tezinaKG > self.getSlobodanProstor(brVagona):
            return False
        self.vagoni[brVagona].dodajRobu(teret)
        return True
    
    def getMarkaNajtezeRobe(self):
        kgNajteze = 0
        markaNajteze = "PRAZAN"
        for v in self.vagoni:
            for r in v.teret:
                if r.tezinaKG > kgNajteze:
                    markaNajteze = r.marka
                    kgNajteze = r.tezinaKG
        return markaNajteze
        
    def __str__(self):
        ret = "TERETNI VOZ\n"
        ret += "Maksimalna tezina po vagonu = " + str(self.vagonMaxKG) + " KG\n"
        for v in self.vagoni:
            ret += "---------------------------------------\n"
            ret += str(v)
            ret += "\n---------------------------------------\n"
        return ret