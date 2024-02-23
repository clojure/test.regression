#!/bin/bash

# shellcheck disable=SC2164
cd "$HOME/.m2/repository/org/clojure/clojure"
LATEST_CLJ_BUILD=$(find . -type d -name "*" -exec basename {} \; | sort -V | tail -n 1)
echo "Latest snapshot version found: $LATEST_CLJ_BUILD"
echo "LATEST_CLJ_BUILD=$LATEST_CLJ_BUILD" >> "$GITHUB_ENV"
