/**
 * AnyServer -- Praktikum Experimentierkasten -- ADS
 *
 * @author E. Mumprecht
 * @version 1.0 -- Geruest fuer irgendeinen Server
 */

package ch.zhaw.rhiana.ads.Praktikum08;

import ch.zhaw.rhiana.ads.CommandExecutor;

public class AnyServer implements CommandExecutor {



    //----- Dies implementiert das CommandExecutor Interface.
    @Override
    public String execute(String command) {
        StringBuffer result = new StringBuffer(100);
        result.append("Die Eingabe war \"");
        result.append(command);
        result.append("\"\n");
        return result.toString();
    }
}//AnyServer   
