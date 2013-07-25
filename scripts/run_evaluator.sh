CLASSNAME=com.hadooptraining.recommender.evaluator.IREvaluatorIntro

pushd `dirname $0` > /dev/null
SCRIPTPATH=`pwd -P`
popd > /dev/null

JVM="-Xmn100M -Xms500M -Xmx500M"
source $SCRIPTPATH/setclasspath.sh
java $JVM -classpath $CLASSPATH $CLASSNAME $1 $2 $3 $4
