package dit.hua.compiler.type;

import java.util.Iterator;
import java.util.List;

public class HeaderType extends DataType {

    private List<DataType> args;
    private DataType res;

    public HeaderType(List<DataType> args, DataType res) {
        this.args = args;
        this.res = res;
    }

    public List<DataType> getArgs() { 
        return args; 
    }

    public boolean equals(DataType t){
        if(t instanceof HeaderType){
            HeaderType that = (HeaderType)t;
            
            if (this.args.size() == that.args.size()) {
                Iterator<DataType> thisArg = this.args.iterator();
                Iterator<DataType> thatArg = that.args.iterator();
                while (thisArg.hasNext() && thatArg.hasNext()) {
                    if (thisArg.next().equals(thatArg.next()))
                        continue;
                    else
                        return false;
                }
            }
            return this.res.equals(that.res);
        }
        return false;

    }

    public DataType getResult() {
        return res; 
    }
    
}
