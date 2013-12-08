package org.lars.ml.reader;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import org.lars.ml.data.Dataset;
import org.lars.ml.data.Observation;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: larswright
 * Date: 12/6/13
 * Time: 7:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class MLFileReader {

    private static final String DELIM = ",";
    private static final int CLASS_POSITION = 4;

    /**
     * Read a comma seperated file and return a Dataset object.  Includes generating Observation objects and also
     * reading the entire file for a unique set of classes.
     * @param mlInput
     * @return
     */
    public static Dataset readFile(File mlInput) {
        try {
            return Files.readLines(mlInput, Charset.defaultCharset(), new LineProcessor<Dataset>() {

                List<Observation> observations = Lists.newArrayList();
                Multiset<String> classes = HashMultiset.create();

                @Override
                public boolean processLine(String line) throws IOException {
                    Observation obs = new Observation(line, DELIM, CLASS_POSITION);
                    observations.add(obs);
                    classes.add(obs.getClazz());
                    return true;
                }

                @Override
                public Dataset getResult() {
                    Map<String, Integer> classMetadata = Maps.newHashMap();
                    String[] distinctClasses = classes.elementSet().toArray(new String[]{});
                    for (int i = 0; i < distinctClasses.length; i++) {
                        classMetadata.put(distinctClasses[i], i);
                    }

                    return new Dataset(observations, classMetadata);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

}
