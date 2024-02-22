(ns regression.datomic-pro.smoke-test
  (:require
    [clojure.test :refer :all]
    [test.regression.datomic-pro :as sut]))

(deftest create-transact-and-query-db
  (let [_ (sut/create-db)
        conn (sut/conn)]
    (sut/transact-schema conn)
    (sut/transact-entities conn)
    (is (= 2 (sut/count-foos conn)))))
