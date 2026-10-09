A minimal Java web server built with the JDK's built-in com.sun.net.httpserver package. No external libraries or frameworks required.

When you visit the server in your browser, it responds with a simple greeting message.

Features
Lightweight HTTP server using only the Java standard library
Listens on port 8000
Responds to requests at / with a plain text message
Graceful error message if the server fails to start (for example, if the port is already in use)
Requirements
Java Development Kit (JDK) 8 or newer

You can check your installed version with:

bash
java -version
Getting Started
1. Clone the repository
bash
git clone https://github.com/<your-username>/<your-repo-name>.git
cd <your-repo-name>
2. Compile
bash
javac SimpleWebServer.java
3. Run
bash
java SimpleWebServer

You should see:

Server is running on http://localhost:8000
4. Open in your browser

Go to http://localhost:8000 and you will see:

Jaden, This is a simple Java server.

You can also test it from the command line:

bash
curl http://localhost:8000

To stop the server, press Ctrl + C in the terminal.

How It Works
HttpServer.create(...) creates a server bound to port 8000.
server.createContext("/", new HelloHandler()) routes all requests at / to HelloHandler.
HelloHandler implements HttpHandler. It sends a 200 OK response header and writes the message to the response body.
server.setExecutor(null) uses the default executor, so requests are handled on a single thread.
Customization

Change the port: edit this line in main:

java
int port = 8000;

Change the message: edit this line in HelloHandler:

java
String response = ("Jaden, This is a simple Java server.");

Recompile and rerun after making changes.

Troubleshooting
Problem	Fix
Failed to start server: Address already in use	Another program is using port 8000. Stop it or change the port.
javac: command not found	Install a JDK and make sure it is on your PATH.
Browser can't connect	Make sure the server is still running and you are using http:// (not https://).
