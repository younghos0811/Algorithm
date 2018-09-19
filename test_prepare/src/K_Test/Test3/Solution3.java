package K_Test.Test3;


/**
 *
 *
 * use bfs & bit mask
 *
 *
 */


import java.util.*;

class Solution3 {

    String[][] relation;
    int colSize;
    int rowSize;
    List<Integer> keyList = new ArrayList<>();

    private static class Node {
        int[] keySet;
        int lastNum = 0;

        private void setKeySet(int[] preKeySet, int num) {
            int[] newKeySet = new int[preKeySet.length+1];

            for(int i = 0; i < preKeySet.length; i++)
                newKeySet[i] = preKeySet[i];
            newKeySet[newKeySet.length-1] = num;
            this.keySet = newKeySet;
        }
    }

    public int solution(String[][] relation) {
        this.relation = relation;
        colSize = relation[0].length;
        rowSize = relation.length;
        int answer = 0;
        Queue<Node> que = new LinkedList<>();

        for(int i = 0; i < colSize; i++) {
            Node node = new Node();
            node.lastNum = i;
            node.keySet = new int[1];
            node.keySet[0] = i;
            que.offer(node);
        }

        while(!que.isEmpty()) {
            Node node = que.poll();

            if(isUniqueKeys(node.keySet)){
                //unique
                answer++;
            }
            else {
                //not unique , require add key
                for(int i = node.lastNum + 1; i < colSize; i++) {
                    Node newNode = new Node();
                    newNode.setKeySet(node.keySet, i);
                    newNode.lastNum = i;
                    que.offer(newNode);
                }
            }
        }

        return answer;

    }

    private boolean isUniqueKeys(int[] keySet) {

        //first unique check
        Map<String,Boolean> map = new HashMap();
        for(int i = 0; i < rowSize; i++) {
            String[] row = relation[i];
            StringBuilder checkSb = new StringBuilder();
            for(int j = 0; j < keySet.length; j++) {
                checkSb.append("|" + row[keySet[j]]);
            }

            if(map.get(checkSb.toString()) != null) {
                return false;
            }
            else {
                map.put(checkSb.toString() , true);
            }
        }

        //second ambiguiouse check
        int thisKeyNum = getKeyNum(keySet);
        for(int i = 0; i < keyList.size(); i++) {
            int keyNum = keyList.get(i);

            if((thisKeyNum & keyNum) == keyNum) {
                return false;
            }
        }
        keyList.add(thisKeyNum);
        return true;
    }

    private int getKeyNum(int[] keySet) {

        int keyNum = 0;
        for(int i = 0; i < keySet.length; i++) {
            keyNum += 1 << (keySet[i]);
        }

        return keyNum;
    }



}
