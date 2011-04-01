package taghero

class ScoreController {


//This is the routing point of our app

    def index = {

	//In grails I don't need ;

	//def define a var
	def result=[]

	//return the list
	//result

	//This is a short-cut to answer directly a xml instead of xml template or html template (similar to jsp)
	//grails POWER

	render(contentType:"application/xml"){
		scoreResults("scoreResults")
		
		}


    }

}
