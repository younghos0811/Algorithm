package Test.Test2;

import java.util.Arrays;

class Solution {

    private static class Stage implements Comparable<Stage>{
        int stageNum = 0;
        int userCnt = 0;
        int successCnt = 0;
        double faileRate = 0;

        void setFaileRate() {
            this.faileRate = (double) (this.userCnt -this.successCnt)/this.userCnt;
        }

        @Override
        public int compareTo(Stage o) {
            if(o.faileRate > this.faileRate) {
                return 1;
            }
            else if(o.faileRate < this.faileRate) {
                return -1;
            }
            else {
                return this.stageNum - o.stageNum;
            }
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Stage[] arr = new Stage[N];

        for(int i = 0; i < N; i++) {
            Stage stage = new Stage();
            stage.stageNum = i+1;
            arr[i] = stage;
        }

        //stage보다 높은 숫자 에러 처리 필요!! (그냥 패스)
        for(int i = 0; i < stages.length; i++) {
            int thisStage = stages[i];
            if(thisStage > N) {
                //user cnt랑 success ++ 하자
                for(int j = 0; j < N; j++){
                    arr[j].userCnt++;
                    arr[j].successCnt++;
                }
                continue;
            }

            for(int j = 0; j < (thisStage-1); j++){
                arr[j].userCnt++;
                arr[j].successCnt++;
            }
            arr[thisStage-1].userCnt++;
        }

        for(int i = 0; i < N; i++) {
            arr[i].setFaileRate();
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            answer[i] = arr[i].stageNum;
        }

        return answer;
    }
}
