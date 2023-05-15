## Introduction

**Note** The current version of this client is outdated and will only work with the December 2022 (or earlier) versions of Browsertrix Cloud. An update is on its way and will be deployed shortly.

`browsertrix-api-client` is a Java API client for [Browsertrix Cloud](https://github.com/webrecorder/browsertrix-cloud). The client supports authentication and provides an easy way to access its various services and endpoints.

## Usage

To set up an API connection to Browsertrix Cloud, simply instantiate the client and connect to the server:

```java
BrowsertrixClient client = new BrowsertrixClient(URL, PORT, USERNAME, PASSWORD);
client.connect();
```

In order to use the various features of the Browsertrix API, the client exposes a number of services. For instance, to get a list of archives, simply call:

```java
ArchiveListResponse response = client.getArchiveService().listArchives();
System.out.println(response.toString());
```

This results in:

```yaml
ArchiveListResponse [
Archive [id=b5fef53a-fbf2-40ed-8b5f-3e27e1608ef7, name=John Smith's Archive] 
Archive [id=6a76fd7a-677b-4da9-8bdd-005b79cdc265, name=Jane Doe's Archive] 
]
```

If you already have the IDs, you can make more specific queries. For instance, to get the crawl config with ID `e7849083-cb84-495c-a4dc-e8489cf8fe96` from the archive with ID `b5fef53a-fbf2-40ed-8b5f-3e27e1608ef7`, you simply call:

```java
CrawlConfig response = client.getCrawlService().getCrawlConfigById("b5fef53a-fbf2-40ed-8b5f-3e27e1608ef7", "e7849083-cb84-495c-a4dc-e8489cf8fe96");
System.out.println(response.toString());
```

This results in:

```yaml
CrawlConfig [
id=e7849083-cb84-495c-a4dc-e8489cf8fe96, 
aid=b5fef53a-fbf2-40ed-8b5f-3e27e1608ef7, 
name=MyConfig,
lastCrawlState=complete, 
lastCrawlTime=2022-08-16T06:43:43, ...
]
```

### Triggering a crawl

Starting from version `0.0.4`, the client is able to run crawls directly via API. The syntax is straightforward:

````java
String crawlId = client.getCrawlService().runCrawl(archiveId, crawlConfigId);
System.out.println("Successfully started crawl with ID '" + crawlId + "'");
````

The above command will run a crawl based on the given crawl configuration, inside the given archive.



### Authentication
Once the connection to the server has been established and the user logged in using the given credentials, `browsertrix-api-client` will take care of authenticating each request in a transparent manner (using the authentication token received from the server). If an API session is timed out, the client will automatically re-establish the connection so you can keep on using the same `BrowsertrixClient` as long as you like.

### Filtering
While the Browsertrix Cloud API does not support filtered requests for the moment, `browsertrix-api-client` is able to filter lists returned by the API on the client side. An example is shown below, for filtering all crawls within a given collection that are completed successfully since 30 days ago:

```java
CrawlFilter filter = new CrawlFilter();
filter.setCrawlState(CrawlState.COMPLETE);
filter.setFinishedAfter(Instant.now().getEpochSecond() - 24*60*60*30); // i.e., 30 days ago, in seconds
System.out.println(client.getCrawlService().listCrawlsByArchiveId(id, filter)); 
```

Two types of filters exist:
  * `CrawlFilter`: filters crawls,
  * `CrawlConfigFilter`: filters crawl configurations (templates).


## List of API services

Currently `browsertrix-api-client` supports the following services:
 * `AuthenticationService` : for everything related to authentication, login, and user self identification,
 * `ArchiveService` : requests related to archives (collections of crawls),
 * `BrowserProfileService` : special browser configurations used within the context of crawl configs,
 * `CrawlService` : everything about crawls and crawl configs.
 
## Examples

You can find examples for every supported API call in the `src/test/java/AppTest.java` class. 

 
