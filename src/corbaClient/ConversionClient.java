package corbaClient;

import corbaConversion.IConversionRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class ConversionClient {
    public static void main(String[] args) throws NamingException {
        // Récupérer les propriétés de l'annuaire JNDI
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sum.jndi.cosnaming.CNCtxFactory");
        props.put(Context.PROVIDER_URL, "iiop://localhost:900");
        Context ctx = new InitialContext(props);
        // Récupérer la référence de l'objet à utiliser
        Object obj = ctx.lookup("IconversionRemote");
        // creation du stub
        IConversionRemote conversion = (IConversionRemote) obj;
        System.out.println(conversion.conversionMontant(70.0F));
        System.out.println(conversion.conversionMontant(150.0F));
        System.out.println(conversion.conversionMontant(125.50F));

    }
}
