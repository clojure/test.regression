(ns regression.datomic-local.smoke-test
  (:require
    [clojure.test :refer :all]
    [test.regression.datomic-local :as sut]))

(def test-db-name "test-db")

(deftest create-and-list-db
  (sut/create-db test-db-name)
  (is (= [test-db-name] (sut/list-dbs))))

(deftest query-db
  (let [_ (sut/create-db test-db-name)
        conn (sut/conn test-db-name)]
    (sut/transact-schema conn)
    (sut/transact-entities conn)
    (is (= 2 (sut/count-foos conn)))))