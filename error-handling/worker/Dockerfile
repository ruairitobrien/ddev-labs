FROM python:2.7-alpine
RUN pip install flask requests
RUN mkdir /app
WORKDIR /app
COPY . /app
CMD python server.py