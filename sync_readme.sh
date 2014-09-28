#!/bin/bash
cat ~/git/RxJavaTest/head >  ~/git/RxJavaTest/README.md
cat ~/git/RxJavaTest/app/src/main/java/com/sharyuke/rxjavatest/MyActivity.java >> ~/git/RxJavaTest/README.md
cat ~/git/RxJavaTest/foot  >>  ~/git/RxJavaTest/README.md
git add ~/git/RxJavaTest/README.md
git commit -m 'update readme'