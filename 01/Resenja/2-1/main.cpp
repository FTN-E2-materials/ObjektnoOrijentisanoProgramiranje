#include <iostream>
using namespace std;

enum PozicijaElemenata {IZNAD_DIJAGONALE, ISPOD_DIJAGONALE, DIJAGONALA};

void unosElemenata(int** matrica, int dimenzija) {
    cout << "Unos elemenata matrice" << endl;

    for(int i = 0; i < dimenzija; i++){
        for(int j = 0; j < dimenzija; j++){
            cout << "\tmatrica[" << i << "][" << j << "] = ";
            cin >> matrica[i][j];
        }
    }
    cout << endl;
}

int suma(int** matrica, int dimenzija, PozicijaElemenata pozicija){
    int suma = 0;

    switch(pozicija){
        case IZNAD_DIJAGONALE:
            for(int i = 0; i < dimenzija; i++){
                for(int j = 0; j < dimenzija; j++){
                    if(i < j){  		// indeksa reda je uvek manji od indeksa kolone
                        suma += matrica[i][j];
                    }
                }
            }
            break;
        case DIJAGONALA:
            for(int i = 0; i < dimenzija; i++){
                for(int j = 0; j < dimenzija; j++){
                    if(i == j){			// indeksa reda je jednak indeksu kolone
                        suma += matrica[i][j];
                    }
                }
            }
            break;
        case ISPOD_DIJAGONALE:
            for(int i = 0; i < dimenzija; i++){
                for(int j = 0; j < dimenzija; j++){
                    if(i > j){
                        suma += matrica[i][j]; // indeks reda je uvek veci od indeksa kolone
                    }
                }
            }
            break;
    }
    return suma;
}


int main()
{
    int n;
    int **matrica;

    cout << "Dimenzija matrice: ";
    cin >> n;
    cout << endl;

    if (n <= 0) {
        cout << "Greska: Dimenzija mora biti pozitivan broj" << endl;
        return 0;
    }

    // rezervacija memorije za 1. dimenziju
    matrica = new int*[n];

    if(matrica == NULL){
        cout << "Greska: Racunar nema dovoljno memorije" << endl;
        return 0;
    }

    for(int i = 0; i < n; i++){
        // rezervacija memorije za 2. dimenziju
        matrica[i] = new int[n];
        if(matrica[i] == NULL){
            cout << "Greska: Racunar nema dovoljno memorije" << endl;
            return 0;
        }
    }

    unosElemenata(matrica, n);

    cout << "Suma elemenata iznad glavne dijagonale: " << suma(matrica, n, IZNAD_DIJAGONALE) << endl;
    cout << "Suma elemenata glavne dijagonale: " << suma(matrica, n, DIJAGONALA) << endl;
    cout << "Suma elemenata ispod glavne dijagonale: " << suma(matrica, n, ISPOD_DIJAGONALE) << endl;

    // oslobadjanje dinamicki alocirane memorije
    for(int i = 0; i < n; i++){
        delete[] matrica[i];
    }
    delete[] matrica;

    return 0;
}

