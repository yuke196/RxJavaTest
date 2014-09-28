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
        Log.i("--我比subscribe先执行 ————-这是Integer->>", "----->> " + a);
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
    ls.add("天使");
    ls.add("娘子");
    ls.add("美丽");
    ls.add("永远");

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

    query("可惜").subscribe(new Action1<List<String>>() {
      @Override public void call(List<String> strings) {
        for (String str : strings) {
          System.out.println("---我是无敌------->>>   " + str);
        }
      }
    });
    //------------------以上的都没问题

    query("可惜", "不可惜").subscribe(new Action1<List<String>>() {
      @Override public void call(List<String> strings) {
        for (String str : strings) {
          System.out.println("---我是无敌 第二代------->>>   " + str);
        }
      }
    });

    query("可惜", "不可惜", "非常不可惜").flatMap(new Func1<List<String>, Observable<String>>() {
      @Override
      public Observable<String> call(List<String> urls) {
        for (String s : urls) {
          Log.i("TAG=--->> ", "--->>  " + s);
        }
        return Observable.from(urls);
      }
    }).flatMap(new Func1<String, Observable<String>>() {
      @Override public Observable<String> call(String s) {
          Log.i("TAG=--->> ", "--单个->>  " + s);
        return Observable.from(s);
      }
    }).toList().subscribe(new Action1<List<String>>() {
      @Override public void call(List<String> strings) {
        for (String str : strings) {
          System.out.println("---我是无敌 第三代------->>>   " + str);
        }
      }
    });

    //测试


    query("可惜", "不可惜", "非常不可惜").flatMap(new Func1<List<String>, Observable<String>>() {
      @Override
      public Observable<String> call(List<String> urls) {
        for (String s : urls) {
          Log.i("T11111G=--->> ", "--->>  " + s);
        }
        return Observable.from(urls);
      }
    }).flatMap(new Func1<String, Observable<String>>() {
      @Override public Observable<String> call(String s) {
          Log.i("T11111G=--->> ", "--单个->>  " + s);
        return Observable.from(s);
      }
    }).subscribe(new Action1<List<String>>() {
      @Override public void call(List<String> strings) {
        for (String str : strings) {
          System.out.println("--1111-我是无敌 第三代------->>>   " + str);
        }
      }
    });

    /*
      }).subscribe(new Action1<List<String>>() {  ---->>>>  }).toList().subscribe(new Action1<List<String>>() {
      0 9-25 14:48:50.996  32362-32362/com.sharyuke.rxjavatest W/System.err﹕ RxJava => Could not find function language adaptor: Groovy with path: rx.lang.groovy.GroovyAdaptor
      09-25 14:48:50.996  32362-32362/com.sharyuke.rxjavatest W/System.err﹕ RxJava => Could not find function language adaptor: JRuby with path: rx.lang.jruby.JRubyAdaptor
      09-25 14:48:50.996  32362-32362/com.sharyuke.rxjavatest W/System.err﹕ RxJava => Could not find function language adaptor: Clojure with path: rx.lang.clojure.ClojureAdaptor
      09-25 14:48:50.996  32362-32362/com.sharyuke.rxjavatest W/System.err﹕ RxJava => Could not find function language adaptor: Scala with path: rx.lang.scala.ScalaAdaptor
      就不发生这的错误了

     */
    //试看看readme文件是否被同步到这个文件

    //query("Hello, world!")
    //    .flatMap(urls -> Observable.from(urls))
    //    .flatMap(url -> getTitle(url))
    //    .filter(title -> title != null)
    //    .subscribe(title -> System.out.println(title));
  }

  Observable<List<String>> query(String text) {
    return Observable.from(text).toList();
  }

  Observable<List<String>> query(String... text) {
    return Observable.from(text).toList();
  }

  Observable<List<Integer>> query(Integer text) {
    return Observable.from(text).toList();
  }

  Observable<List<Integer>> query(Integer... text) {
    return Observable.from(text).toList();
  }
}