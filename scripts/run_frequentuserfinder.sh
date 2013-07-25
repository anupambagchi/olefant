CLASSNAME=com.hadooptraining.recommender.MostFrequentUserFinder

pushd `dirname $0` > /dev/null
SCRIPTPATH=`pwd -P`
popd > /dev/null

JVM="-Xmn100M -Xms500M -Xmx500M"
echo Deleting old file...
hadoop fs -rm -r output
echo Running Hadoop file creation task...
hadoop jar $SCRIPTPATH/../target/olefant-1.0.jar $CLASSNAME data/input1 output
echo Here is the output...
hadoop fs -cat output/part-r-00000