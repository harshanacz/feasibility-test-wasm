package test;

import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.TextDocumentSyncKind;
import org.eclipse.lsp4j.CompletionOptions;

public class Main {

    public static void main(String[] args) {

        // TEST 1: Can we create LSP4J data objects? (no Gson involved)
        try {
            InitializeParams params = new InitializeParams();
            params.setProcessId(1234);
            System.out.println("TEST1 PASS: InitializeParams pid=" + params.getProcessId());
        } catch (Exception e) {
            System.out.println("TEST1 FAIL: " + e.getMessage());
        }

        // TEST 2: ServerCapabilities object
        try {
            ServerCapabilities caps = new ServerCapabilities();
            caps.setTextDocumentSync(TextDocumentSyncKind.Full);
            CompletionOptions completion = new CompletionOptions();
            caps.setCompletionProvider(completion);
            System.out.println("TEST2 PASS: ServerCapabilities created OK");
        } catch (Exception e) {
            System.out.println("TEST2 FAIL: " + e.getMessage());
        }

        // TEST 3: Simple string building (manual JSON, no library)
        try {
            String method = "initialize";
            int id = 1;
            String manualJson = "{\"jsonrpc\":\"2.0\",\"id\":" + id + ",\"method\":\"" + method + "\"}";
            System.out.println("TEST3 PASS: Manual JSON = " + manualJson);
        } catch (Exception e) {
            System.out.println("TEST3 FAIL: " + e.getMessage());
        }

        System.out.println("Done.");
    }
}