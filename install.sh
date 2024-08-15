#!/usr/bin/env bash

set -ex

pushd api
  docker build -t eldermael/ffapi .
popd

helmfile apply

