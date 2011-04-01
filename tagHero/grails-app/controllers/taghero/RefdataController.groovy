package taghero

// import org.springframework.beans.factory.InitializingBean
//import groovyx.net.http.RESTClient
//import groovy.util.slurpersupport.GPathResult
//import static groovyx.net.http.ContentType.URLENC
import static groovyx.net.http.ContentType.XML

class RefdataController {

    def index = { 

      // This declares an array-list and populates it with three string elements
      def results = [ 'one', 'two', 'three' ]

      example2();

      // Wrap each item in the results array in an outer <refdata> tag with an <item> tag for each array member
      render(contentType:"application/xml") {
        refdata() {
          results.each { the_ref_item ->
            item(the_ref_item)
          }
        }
      }

    }

  def example2() {
    withHttp(uri: "http://api.europeana.eu") {
      def xml = get(path : '/api/opensearch.rss', query : [searchTerms:'text:"art nouveau"', wskey:'DUXTJIRHCZ'], contentType : XML)
      // println "XML: ${xml}"
      println "Class: ${xml.getClass().getName()}."
      println "Result count: ${xml.channel.totalResults}"
      println "Iterating results....  -${xml.@version}- title:-${xml.channel.title}-"
      xml.channel.item.each {
        println "Got an item - Title is ${it.title.text()}"
      }
    }
  }
}
