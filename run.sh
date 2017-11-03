docker run --rm --name mongo -p 27017:27017 -d mongo
docker run --rm --name app -p 8080:8080 --link mongo:mongo -d app
docker run --rm --name client -p 80:80 --link app:app -d client
