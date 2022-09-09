/* 일단 루트노드는 1번 언급된게 루트노드니까 번호가 언급이 될때마다 카운트를해서 1번 언급된 애가 루트노드.
	트리 구성은 자식이 둘이므로  pair이용.
	그리고 중위순회를 통해 열번호를 매겨나감. */
#include<iostream>
#include<utility>


using std::cin;
using std::cout;
using std::pair;
using std::min;
using std::max;
using std::endl;

#define MAX 10000

void inorderTraversal(int root, int level);


int xPos[MAX + 1], yPos[MAX + 1]; // 각각 x좌표 , y좌표
int maxV, maxPos;
int N, root, num, level; // num은 x좌표 번호매길떄 쓰려고 level은 y좌표 (트리의 높이)
int left, value, right; // count 배열에서 번호 언급 횟수 셀때 이용
pair<int, int> node[MAX + 1];  // pair에 왼쪽, 오른쪽 자식 저장.
int count[MAX + 1]; // count배열을 통해 2인놈을 걸러냄
int low[MAX + 1];
int high[MAX + 1];

int main() {
	maxV = 0; level = 1;

	//count,low,high 초기화
	for (int i = 0; i < MAX + 1; i++)
		count[i] = 0;
	for (int i = 0; i < MAX + 1; i++)
		low[i] = MAX+2;
	for (int i = 0; i < MAX + 1; i++)
		high[i] = 0;
	cin >> N;
	// N번만큼 입력받아서 번호가 언급될때마다 카운트. -1일떄는 제외 그리고 node에 저장.
	for (int i = 0; i < N; i++) {
		cin >> value >> left >> right;
		node[value].first = left;
		node[value].second = right;
		if(left != -1)
		count[left]++;
		count[value]++;
		if(right != -1)
		count[right]++;
	}
	//  한번언급 된 애가 루트니까 루트 찾음
	for(int i= 0; i <MAX+1; i++)
		if (count[i] == 1) {
			root = i;
			break;
		}

	inorderTraversal(root, level);
	for (int i = 1; i < MAX + 1; i++) {
		if (maxV < high[i] - low[i] + 1) {
			maxV = high[i] - low[i] + 1;
			maxPos = i;
		}
	}
	cout << maxPos << " " << maxV;
	return 0;
}
void inorderTraversal(int root,  int level){
	// node. left 방문. (first)
	if(node[root].first > 0)
	inorderTraversal(node[root].first, level+1);
	// 번호 매기고 , low값과 high 값 갱신
	xPos[root] = num++;
	low[level] = min(low[level], xPos[root]);
	high[level] = max(high[level], xPos[root]);
	// node.right 방문 (second)
	if (node[root].second > 0)
	inorderTraversal(node[root].second, level+1);
}
