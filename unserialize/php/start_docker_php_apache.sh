#!/bin/bash
sudo docker run -d -p 80:80 --name my-apache-php-app -v "$PWD":/var/www/html/php php:7.0-apache
