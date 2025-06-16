build:
    tectonic -X build

watch:
    tectonic -X watch

lint:
    chktex src/*.tex

format:
    latexindent -w src/*.tex

start:
   code .
   zathura build/thesis/thesis.pdf &
   just watch

check: lint && format

sync:
	git add -A
	git commit -m "Sync {{`date +'%Y-%m-%d %H:%M:%S'`}}"