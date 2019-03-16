'''
Created on Dec 25, 2018

@author: Marko
'''

class Roba:

    def __init__(self, marka = "Nike", naziv = "patike", tezinaKG = 1):
        self.marka = marka
        self.naziv = naziv
        self.tezinaKG = tezinaKG
    
    def __str__(self):
        return "(\"" + self.marka + "\", \"" + self.naziv + "\", " + str(self.tezinaKG) + ")"        