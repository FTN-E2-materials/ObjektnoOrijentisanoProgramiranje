'''
Created on Dec 25, 2018

@author: Marko
'''

class Vagon:

    def __init__(self):
        self.opisTereta = "PRAZAN"
        self.teret = []
        
    def getTezinaRobe(self):
        suma = 0;
        for t in self.teret:
            suma += t.tezinaKG
        return suma
    
    def dodajRobu(self, roba):
        self.teret.append(roba)
        self.opisTereta = self.teret[0].marka
        for t in self.teret:
            if t.marka != self.opisTereta:
                self.opisTereta = "RAZNO"
                break
    
    def __str__(self):
        ret = "teret "
        count = len(self.teret)
        if count == 0:
            ret += "prazan"
        for t in range(count):
            ret += str(self.teret[t])
            if t < count - 1:
                ret += ", "
        ret += " > opisTereta = \"" + self.opisTereta + "\""
        return ret