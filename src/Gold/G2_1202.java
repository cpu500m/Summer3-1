/* 2022-06-25 일곱번째로 푼 문제 */
// 가장 먼저 생각해 볼 수 있는 방법이
// 보석의 가격을 내림차순으로 정렬한 후
// 보석의 무게와 가방의 한도를 비교하여 집어넣는 방식.
// 256,000,000 bytes 만큼이 가용공간이니까 일단 메모리 측면에서 따져보면
// Map을 이용해서 보석의 무게와 값을 저장하고 ( 무게를 key로 잡은 다음. value에 arraylist를 연결하여
// arrayList에 보석의 값들을 저장. 값들은 내림차순으로 정렬.)
// ( 300,000 * ( <Integer, ArrayList>) + 기타 공간)
// Map을 이용해서 가방, 무게 저장 ( 300,000 * ( <Integer,Integer>차지 공간) + 기타 공간들)
// 메모리는 충분.
// 시간 복잡도를 따져보면
// 만약 가방의 무게한도 순으로 내림차순 정렬을 안하고 최적을 찾는다고 하면
// 300,000개의 가방에 대해 각각 최악의 경우 300,000개의 보석들을 따져보아야 하므로 O(n^2)의 시간복잡도를 가짐.
// 만약 가방의 무게한도가 내림차순으로 정렬 돼 있다면
// 300,000개의 보석들 각각에 대해 한번씩만 체크하면 되므로
// 시간복잡도는 O(n).
// 따라서 보석의 가치와 가방의 최대 한도를 둘 다 내림차순으로 정렬 한 후에 최적의 값을 찾을필요가 있음.

// 처음에는 위와같이 생각했는데..
// Map안의 키를보고 무게에 대응하는 곳을 찾고 값을 집어넣고 하는 과정에서 시간이 오래 걸릴 것같아서
// 다른방법을 생각해봄.
// 보석과 가방에 대한 클래스를 만들고 클래스 배열을 만들어서 정렬하여
// 값을 계산하는건 어떨까 라고 생각했음.

// 처음 생각헀던 아이디어로 돌려보니까 (가방 무게와 보석 가치를 내림차순으로 정렬하는 방식 ) 이러면
// 예를들어서 가방 한도가 5 , 7 가있고
// 보석이 무게가 5인데 200만원 , 6인데 100만원 이렇게 있으면
// 200만원짜리를 먼저 7에넣으니까 5에 아무것도 안들어감. 그래서 고쳤음.
//  근데 이방식 대로 하니깐 시간 초과 발생.
//  그래서 또 새로운 방식을 생각.

// 가방한도를 오름차순으로 정렬하고 우선순위 큐를 이용하여
// 가방이 담을 수 있는 모든 보석의 무게를 우선순위 큐에 넣고 큐의 맨 위 값을
// 하나 빼서 최적값에 더하는 연산을 가방 갯수만큼 반복.
package Gold;


import java.util.*;

class Jewel{
    private int weight;
    private int value;
    public Jewel(int weight, int value){
        this.value = value;
        this.weight = weight;
    }
    public int getValue() {
        return value;
    }
    public int getWeight() {
        return weight;
    }
}
public class G2_1202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jewel_count = scanner.nextInt();
        Jewel[] jewels = new Jewel[jewel_count];
        int knapsack_count = scanner.nextInt();
        int[] knapsacks = new int[knapsack_count];
        PriorityQueue<Integer> jewelQueue = new PriorityQueue<>(Collections.reverseOrder());
        // 현재까지 담은 보석
        int cur_jewel = 0;
        //  최적의 값
        long opt_value = 0;
        for (int i = 0; i < jewel_count; i++) {
            jewels[i] = new Jewel(scanner.nextInt(), scanner.nextInt());
        }
        for (int i = 0; i < knapsack_count; i++) {
            knapsacks[i] = scanner.nextInt();
        }
        // 정렬
        Arrays.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });
        Arrays.sort(knapsacks);
        for (int i = 0; i < knapsack_count; i++) {
            while(cur_jewel < jewel_count &&knapsacks[i]>= jewels[cur_jewel].getWeight()) {
                jewelQueue.add(jewels[cur_jewel].getValue());
                cur_jewel++;
            }
            if(jewelQueue.peek() != null) {
                opt_value += jewelQueue.poll();
            }
        }
        System.out.print(opt_value);
    }
}
/* 아래는 두번째로 시도했던 방법 */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int jewel_count = scanner.nextInt();
//        Jewel[] jewels = new Jewel[jewel_count];
//        int knapsack_count = scanner.nextInt();
//        Knapsack[] knapsacks = new Knapsack[knapsack_count];
//        boolean[] contain = new boolean[knapsack_count];
//        // 최적값 구할때 어느 가방까지 넣었는지 확인하기 위함.
//        int cur_knapsack = 0;
//        // 무게차이가 가장 작은 곳에 저장해야하니까 최적의 가방을 찾기위해 존재하는 변수
//        int temp;
//        // 계속 보석 무게 함수호출로 불러오면 시간 오래걸리니까 변수로 만듦
//        int cur_jewel;
//        //  최적의 값
//        long opt_value = 0;
//        for(int i = 0 ; i <jewel_count ; i++){
//            jewels[i]= new Jewel(scanner.nextInt(),scanner.nextInt());
//        }
//        for(int i = 0 ; i <knapsack_count ; i++){
//            knapsacks[i]= new Knapsack(scanner.nextInt());
//        }
//        // 정렬
//        Arrays.sort(jewels, new Comparator<Jewel>() {
//            @Override
//            public int compare(Jewel o1, Jewel o2) {
//                return Integer.compare(o2.getValue(),o1.getValue());
//            }
//        });
//        Arrays.sort(knapsacks, new Comparator<Knapsack>() {
//            @Override
//            public int compare(Knapsack o1, Knapsack o2) {
//                return Integer.compare(o2.getLimit(),o1.getLimit());
//            }
//        });
//        for(int i = 0 ; i < jewel_count ;i++ ){
//            cur_jewel = jewels[i].getWeight();
//                if (cur_knapsack >= knapsack_count)
//                    break;
//                if (knapsacks[cur_knapsack].getLimit() >= cur_jewel) {
//                    // 여기서 최적 가방 찾기 ㄱ
//                    temp =cur_knapsack;
//                    while(cur_knapsack < knapsack_count && knapsacks[cur_knapsack].getLimit() >= cur_jewel){
//                        cur_knapsack++;
//                    }
//                    while(contain[cur_knapsack-1] == true)
//                        cur_knapsack--;
//                    contain[cur_knapsack-1] =true;
//                    cur_knapsack = temp;
//                    opt_value += jewels[i].getValue();
//                    if(contain[cur_knapsack] == true)
//                        cur_knapsack++;
//                    continue;
//                } else continue;
//        }
//        System.out.print(opt_value);
//    }
    /* 아래는 첫번째로 생각했었던 내용 */
//    public static void main(String[] args) {
//        Map<Integer, Integer> jewel = new HashMap<>();
//        Map<Integer,Integer> knapsack = new HashMap<>();
//        Scanner scanner = new Scanner(System.in);
//        int jewel_count = scanner.nextInt();
//        int knapsack_count = scanner.nextInt();
//        int weight, value;
//        // 최적의 값
//        int opt_value = 0;
//        for(int i = 0 ; i < jewel_count ; i ++){
//            weight= scanner.nextInt();
//            value = scanner.nextInt();
//            jewel.put(weight,value);
//        }
//        for(int i = 0 ; i < knapsack_count; i++){
//            weight = scanner.nextInt();
//            knapsack.put(i,weight);
//        }
//        List<Map.Entry<Integer,Integer>> jewel_entryList = new LinkedList<>(jewel.entrySet());
//        jewel_entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o2.getValue() - o1. getValue();
//            }
//        });
//        List<Map.Entry<Integer,Integer>> knapsack_entryList = new LinkedList<>(knapsack.entrySet());
//        knapsack_entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o2.getValue() - o1. getValue();
//            }
//        });
//        for(Map.Entry<Integer,Integer> jewel_entry: jewel_entryList){
//            for(Map.Entry<Integer,Integer> knapsack_entry: knapsack_entryList){
//                if( knapsack_entry.getValue() >= jewel_entry.getKey()){
//                    opt_value+= jewel_entry.getValue();
//                }
//            }
//        }
//    }
