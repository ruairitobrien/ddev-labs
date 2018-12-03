FROM python:2.7-alpine
RUN pip install flask
RUN mkdir /app
WORKDIR /app
COPY . /app
CMD python server.py