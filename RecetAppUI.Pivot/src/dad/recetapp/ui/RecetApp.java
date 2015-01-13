package dad.recetapp.ui;
 
import java.io.IOException;
import java.net.URL;

import org.apache.pivot.beans.BXMLSerializer;
import org.apache.pivot.collections.Map;
import org.apache.pivot.serialization.SerializationException;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Window;

public class RecetApp implements Application {

    private Window loadWindow(String bxmlFile) throws IOException, SerializationException {
    	URL bxmlUrl = this.getClass().getClassLoader().getResource(bxmlFile);
        BXMLSerializer bxmlSerializer = new BXMLSerializer();
        return (Window) bxmlSerializer.readObject(bxmlUrl);
    }
    
    private void openWindow(Display display, String bxml) throws IOException, SerializationException {
    	loadWindow(bxml).open(display);
    }
    
    @Override
    public void startup(Display display, Map<String, String> properties) throws IOException, SerializationException {
    	openWindow(display, "dad/recetapp/ui/views/InitWindow.bxml");
    }
 
    @Override
    public boolean shutdown(boolean optional) { return false; }
 
    @Override
    public void suspend() { }
 
    @Override
    public void resume() { }
    
    public static void main(String [] args) {
		DesktopApplicationContext.main(RecetApp.class, args);
    }
    
}