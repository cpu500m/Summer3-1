#include<iostream>

#define MAX 3072 // 3* 2 ^10

using std::cin;
using std::cout;
using std::endl;


void storeStar(int n , int x , int y);

char star[MAX + 1][2 * MAX + 1]; //배열의 0행과 0열은 안쓸예정. 현실세계의 계산과 유사하게 하기위해 1부터 시작으로
char Tri[][6]= { "  *  ",
				 " * * ",
		 		 "*****"};  //n이 3일때 이 배열을 이용해서 넣으려고
int main() {
	int n;
	for (int i = 1; i < MAX+1; i++) {
		for (int j = 1; j < 2*MAX+1; j++) {
			star[i][j]=' ';
		}
	}
	cin >> n;
	storeStar(n, n, 1); // 1부터 시작으로 따짐
	for (int i = 1; i < n+1; i++) {
		for (int j = 1; j < 2*n; j++) {
			cout << star[i][j];
		}
		if( i != n)
		cout << endl;
	}
	return 0;
}
void storeStar(int n , int x , int y){
	if (n == 3) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				star[y + i][x -2+ j] = Tri[i][j];
			}
		}
		return;
	}
	storeStar(n/2, x,y);
	storeStar(n/2, x-n/2,y+n/2);
	storeStar(n/2, x+n/2,y+n/2);
}
