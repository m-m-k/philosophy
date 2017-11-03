From node:stretch

Expose 80

Volume /root/.npm

Run mkdir /usr/src/app

Copy . /usr/src/app

Workdir /usr/src/app
Run npm install && npm run-script build


CMD node server.js
