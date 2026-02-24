package test;

import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.ServerCapabilities;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) {

        // TEST 1: Basic LSP4J data object
        try {
            InitializeParams params = new InitializeParams();
            params.setProcessId(1234);
            System.out.println("TEST1 PASS: InitializeParams OK, pid=" + params.getProcessId());
        } catch (Exception e) {
            System.out.println("TEST1 FAIL: " + e.getMessage());
        }

        // TEST 2: Basic Gson (no reflection, just tree parsing)
        try {
            String json = "{\"method\":\"initialize\",\"id\":1}";
            JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
            String method = obj.get("method").getAsString();
            System.out.println("TEST2 PASS: Gson basic parse OK, method=" + method);
        } catch (Exception e) {
            System.out.println("TEST2 FAIL: " + e.getMessage());
        }

        // TEST 3: ServerCapabilities object
        try {
            ServerCapabilities caps = new ServerCapabilities();
            System.out.println("TEST3 PASS: ServerCapabilities OK");
        } catch (Exception e) {
            System.out.println("TEST3 FAIL: " + e.getMessage());
        }

        System.out.println("Phase 2 complete.");
    }
}