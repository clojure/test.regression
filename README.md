# test.regression

The purpose of this repository is to test clojure builds against a variety of existing projects and attempt to identify possible regressions.

## Actions

Tests are conducted by running one of four actions:

Required inputs for all actions are the same. 
    1. The source repository. Defaults to clojure/clojure
    2. The branch, tag or SHA to build and used to run the tests

* [test-against-datomic](https://github.com/clojure/test.regression/actions/workflows/test-against-datomic.yml): Runtime ~4 min. Runs basic smoke test against datomic-local and datomic-pro
* [test-against-contrib](https://github.com/clojure/test.regression/actions/workflows/test-against-contrib-and-nu.yml): Runtime ~10 min. Run tests in contrib repos
* [test-all-the-things](https://github.com/clojure/test.regression/actions/workflows/test-all-the-things.yml): Runtime ~45 min. Run test in over one hundred community repositories.
* [test-pinned-repos](https://github.com/clojure/test.regression/actions/workflows/test-pinned-repos.yml): Runtime ~4 min. Run tests against repositories that require pinned SHAs.

## Special Thanks

test.regression was inspired by:
  * [core_regression](https://github.com/NoahTheDuke/core_regression) by [noahtheduke](https://github.com/NoahTheDuke)
  * [cljs-oss](https://github.com/cljs-oss/canary) by [darwin](https://github.com/darwin)

## Copyright and License

Copyright (c) Jarrod Taylor, Rich Hickey, and contributors. All rights reserved. The use and distribution terms for this software are covered by the Eclipse Public License 1.0 (https://opensource.org/license/epl-1-0/) witch can be found in the file LICENSE at the root of this distribution. By using this software in any fashion, you are agreeing to be bound by the terms of this license. You must not remove this notice, or any other, from this software.
