# Simple HTTP Server

## 各言語のバージョン
- Java 1.8
- Scala 2.12
- Clojure 1.8

## 仕様
- localhost:8080で待ち受け、HTTPリクエストを受けとり、HTTPレスポンスを返す
- 対応するHTTPリクエストメソッドは`GET`のみ（それ以外のメソッドもGETとみなす）
- リソースのMIMEは外部ファイルで設定できる
- リクエストをブロックしない（マルチスレッド）
- Keep-Aliveはしない
- HTTP Cacheはしない

## 起動

- Java  
```
$ brew install homebrew/versions/maven32 # if you need
$ mvn compile
$ mvn exec:java
```

- Scala
```
$ brew install sbt # if you need
$ sbt run
```

- Clojure
```
$ brew install leiningen # if you need
$ lein run
```
