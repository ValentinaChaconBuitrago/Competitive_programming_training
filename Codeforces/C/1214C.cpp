#include <bits/stdc++.h>

using namespace std;

int main(){
	//Tener dos pilas: la primera para guardar los parentesis que abren y a medida que encuentro un parentesis que cierra lo saco de la pila
	// si la pila de abiertos esta vacia me toca esperar a que llegue otro que abra para poder cerrar. Entonces en la segunda pila guardo 
	// los que cierran que aun no he podido usar. 
	// al final si me queda algo en alguna de las dos pilas quiere decir que no tengo una buena secuencia

	//OPTIMIZACION: en vez de hacer una pila secundaria puedo usar un contador. Se supone que solo puedo esperar una vez, no muchas
	// entonces, si no lo pude usar lo contabilizo en un contador. Si ya no tengo nada mas que leer uso ese que me sobro para sacar y verificar
	// si ese contador en algun momento es mayor a uno quiere decir que no puedo formar una combinación perfecta.
	int n;
	cin >> n;

	//Step 1: if a number is odd it doesn't work
	if(n%2!=0 && n!=1){
		cout << "No" << endl;
		return 0;
	}

	string seq;
	cin >> seq;

	stack <int> closing_stack;
	int counter = 0;
	for(int i=0;i<n;++i){
		//Case 1: receive an empty string
		if(seq[i]==0){
			cout << "Yes" << endl;
			return 0;
		}
		//Case 2: there is no way to move at most one bracket so that the sequence becomes correct
		if(counter>1){
			cout << "No" << endl;
			return 0;
		}

		//Case 3: general case
		if(seq[i]=='('){
		    //cout << "entra uno que cierra" << endl;
			closing_stack.push(seq[i]);
		}
		else if(!closing_stack.empty() && seq[i]==')'){
		    //cout << "entra uno que sale" << endl;
			closing_stack.pop();
		}
		else if(closing_stack.empty() && seq[i]==')'){
		    //cout << "me toca guardar para despues" << endl;
			counter++;
		}
	}

	if(closing_stack.size()==1 && counter==1){
	    //cout << " hay uno acumulado y queda uno por sacar " << endl;
		closing_stack.pop();
		counter--;
	}
	string ans = "No";
	if(closing_stack.empty() && counter == 0){
	    //cout << "pila vacia y no hay ningun acumulado" <<endl;
		ans = "Yes";
	}
	cout << ans << endl;
	return 0;
}