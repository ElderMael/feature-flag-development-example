.PHONY: build-frontend
build-frontend:
	cd frontend; docker build -t eldermael/frontend .

.PHONY: build-api
build-api:
	cd api; docker build -t eldermael/ffapi .

.PHONY: build-cli
build-cli:
	cd cli; cargo build

.PHONY: build
build: build-api build-cli build-frontend
	echo "Building all components"

.PHONY: deploy
deploy:
	helmfile apply
	cp cli/target/debug/ff "${HOME}/.local/bin"

.PHONY: build-deploy
build-deploy: build deploy
	echo "Building all components and then deploying"