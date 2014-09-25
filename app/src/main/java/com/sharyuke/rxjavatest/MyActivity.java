package com.sharyuke.rxjavatest;

import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.android.concurrency.AndroidSchedulers;
import rx.concurrency.Schedulers;
import rx.util.functions.Action1;
import rx.util.functions.Func1;

public class MyActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);
    Observable.from("one", "two", "three", "four", "five")
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<String>() {
          @Override
          public void call(String s) {
            System.out.println(s);
          }
        });

    //query("Hello, world!").flatMap(new Func1<List<String>, Observable<String>>() {
    //  @Override
    //  public Observable<String> call(List<String> urls) {
    //    return Observable.from(urls);
    //  }
    //}).subscribe(new Action1<String>() {
    //  @Override
    //  public void call(String s) {
    //    System.out.println(s);
    //  }
    //});

    Observable.just("Hello, world!").map(new Func1<String, Integer>() {
      @Override
      public Integer call(String s) {
        return s.length();
      }
    }).subscribe(new Action1<Integer>() {
      @Override
      public void call(Integer s) {
        System.out.println(String.valueOf(s));
      }
    });

    Observable.from(1, 2, 3, 4, 5, 6).flatMap(new Func1<Integer, Observable<Integer>>() {
      @Override
      public Observable<Integer> call(Integer a) {
        Log.i("---这是Integer->>", "----->> " + a);
        return Observable.from(a);
      }
    }).subscribe(new Action1<Integer>() {
      @Override
      public void call(Integer s) {
        System.out.println("--->>>aaa>> " + String.valueOf(s));
      }
    });

    Observable.from("11111", "22222", "333333")
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap(new Func1<String, Observable<String>>() {
          @Override
          public Observable<String> call(String urls) {
            //for (List<String> s : urls) {
            //for (String s1 : urls) {
            //  Log.i("---这是String->>", s1);
            //}
            //}
            return Observable.from(urls);
          }
        })
        .subscribe(new Action1<String>() {

          @Override public void call(String s) {
            System.out.println(s);
          }
        });

    List<String> ls = new ArrayList<String>();
    ls.add("one");
    ls.add("one");
    ls.add("one");
    ls.add("one");

    Observable.from(ls)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap(new Func1<String, Observable<String>>() {
          @Override
          public Observable<String> call(String urls) {
            //for (List<String> s : urls) {
            //for (String s1 : urls) {
            //  Log.i("---这是String->>", s1);
            //}
            //}
            return Observable.from(urls);
          }
        })
        .subscribe(new Action1<String>() {

          @Override public void call(String s) {
            System.out.println("撒旦风口浪尖撒发；就是 " + s);
          }
        });

    //------------------以上的都没问题

  }
}


