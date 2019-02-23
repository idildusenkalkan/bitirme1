package com.example.omer.onlineint.Moduls;



public class Moduls {
/*

        private TestExam testExamRepo;
        private ClassicExam classicExamRepo;
        private State state;
        private ResultResponse resultResponse;



        // SINAV OLUP OLMADIĞINI KONTROL EDEN METOT
        /*  public State CheckExam(String id,String password){
           RestInterface restInterface=ApiClient.getRetrofitInstance().create(RestInterface.class);
            Call<State> call=restInterface.CheckExam(id,password);
            call.enqueue(new Callback<State>() {
                @Override
                public void onResponse(Call<State> call, Response<State> response) {

                    state = response.body();

                }

                @Override
                public void onFailure(Call<State> call, Throwable t) {

                }
            });
            return state;
        }



        // test SINAV VARSA İNDİREN METOT
        public TestExam GetTextExam(String examid){
            RestInterface restInterface=ApiClient.getRetrofitInstance().create(RestInterface.class);
            Call<TestExam> call=restInterface.DlTExam(examid);
            call.enqueue(new Callback<TestExam>() {
                @Override
                public void onResponse(Call<TestExam> call, Response<TestExam> response)
                {
                    testExamRepo = response.body();

                }

                @Override
                public void onFailure(Call<TestExam> call, Throwable t) {

                }
            });
            return testExamRepo;
        }

        // classic SINAV VARSA İNDİREN METOT
        public ClassicExam GetClassicExam(String examid){
            RestInterface restInterface=ApiClient.getRetrofitInstance().create(RestInterface.class);
            Call<ClassicExam> call=restInterface.DlCExam(examid);
            call.enqueue(new Callback<ClassicExam>() {
                @Override
                public void onResponse(Call<ClassicExam> call, Response<ClassicExam> response)
                {
                    classicExamRepo = response.body();

                }

                @Override
                public void onFailure(Call<ClassicExam> call, Throwable t) {

                }
            });
            return classicExamRepo;
        }


        // classic sınavın sonucunu gonderen metot
        public ResultResponse sendCR(ClassicResult classicResult){

            RestInterface restInterface=ApiClient.getRetrofitInstance().create(RestInterface.class);
            Call<ResultResponse> call=restInterface.sendCR(classicResult);
            call.enqueue(new Callback<ResultResponse>() {
                @Override
                public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                    resultResponse=response.body();
                }

                @Override
                public void onFailure(Call<ResultResponse> call, Throwable t) {

                }
            });
            return resultResponse;


        }
        // test sınavın sonucunu gonderen metot
        public ResultResponse sendTR(TestResult testResult){
            RestInterface restInterface=ApiClient.getRetrofitInstance().create(RestInterface.class);
            Call<ResultResponse> call=restInterface.sendTR(testResult);
            call.enqueue(new Callback<ResultResponse>() {
                @Override
                public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                    resultResponse=response.body();

                }

                @Override
                public void onFailure(Call<ResultResponse> call, Throwable t) {


                }
            });

            return resultResponse;

        }*/
}
