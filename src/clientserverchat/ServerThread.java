package clientserverchat;

class ServerThread extends Thread {
    long minPrime;
    CServer server;
    
    ServerThread(long minPrime) {
        this.minPrime = minPrime;
    }

    public void run() {
        this.server = new CServer();
        this.connect(7777);
    }
}
