#include<iostream>
#include<cmath>
#include<vector>
#include<cstdlib>

#define M 1000000

void eratosthenes(bool[]);

using std::cout;
using std::cin;
using std::vector;




int main() {
	int N, temp; // temp는 하나씩 입력받아 임시로 저장할 장소
	//divide는 각 루프때 얼마씩 나눠야 하는지 , score는 최대점수, result는 몇번 연산이필요한지 (즉 score와 result가 최종적으로 얻고자하는 값)

	int divide, score = 1, result = 0;
	// prime은 그 수가 소수인지 판별을 위해 , count는 전체 소수의 갯수를 세기 위함.
	bool *prime = new bool[M + 1];
	int *count = new int[M + 1];
	eratosthenes(prime);
	for (int i = 0; i < M + 1; i++)
		count[i] = 0;
	// 입력받는 곳
	cin >> N;
	// 벡터 생성. num벡터에 소수인 애들 넣어놓음.
	vector<int> primeList;
	for (int i = 2; i <= M; i++)
		if (prime[i])
			primeList.push_back(i);
	// 입력된 N개의 수에 대해서 각각 소인수 분해해서 prime갯수를 셈.
	vector<vector<int>> num(N, vector<int>(primeList.size(), 0));
	for (int i = 0; i < N; i++) {
		cin >> temp;
		// count로 전체 소수의 개수를 세고 , num으로 각각 개별의 소수 개수를 셈.
		for (int j = 0; j < primeList.size(); j++) {
			while (temp % primeList[j] == 0) {
				temp /= primeList[j];
				count[primeList[j]]++;
				num[i][j]++;
			}
		}
	}
	for (int i = 0; i < primeList.size(); i++) {
		divide = count[primeList[i]] / N;
		for (int j = 0; j < N; j++) {
			// num[j][i]에 divide 보다 적게있다면 더나눠줘야함. 그만큼 연산해야하니까 카운트에 추가
			if (num[j][i] < divide) {
				result += divide - num[j][i];
			}
		}
		// score에 소수 i를 각각 나눠준(?)만큼을 계속 곱해감
		score *= (int)pow(primeList[i], divide);
	}
	cout << score << " " << result;

	delete[] prime;
	delete[] count;
	return 0;
}
void eratosthenes(bool prime[]) {
	for (int i = 2; i < M + 1; i++)
		prime[i] = true;
	// 에라토스테네스의 체 적용 . 
	for (int i = 2; i <= sqrt(M); i++) {
		// prime[i]가 false면 소수가 아니므로 다음루프로 넘긴다.
		if (!prime[i])
			continue;
		for (int j = i * i; j <= M; j += i)
			prime[j] = false;
	}
}
