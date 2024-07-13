# Spring Utilities

Spring Beans that would be useful in any Spring project. This will replace SDJK, JavaUtil and FileUtil. It would be easier to strip out the Spring in the future than to add it in

-----------------------------

### [GIT location](https://github.com/sobemurray/Spring-Utils.git)

-----------------------------

### Maven details

> groupId - com.sobetech.maven
>
> artifactId - template

-----------------------------

# Releases

## 1.1.0
##### upcoming

## 1.0.16
##### 07-13-2024
#### FDA-53
New objects for building charts and graphs

## 1.0.15
##### 07-07-2024
#### FDI-258
Added new search criteria annotation for OR and LIKE
#### FDA-24
- Allowing search criteria annotations to be inherited
- Added ability to get fields from a class as well as the super class

#### FDA-50
Added calls to calculate mean and median

## 1.0.14
##### 06-30-2024
#### FDI-162
Preventing error when the source object in copyObjectAttributes is null

## 1.0.13
##### 06-23-2024
#### SU-27
New EditStatus for an entity that cannot be finalized, but cannot be altered to fix it. We didn't want to mask things by bypassing the status. That is why this new status was made. To flag it, but not leave it in permanent limbo
#### SU-28
New criteria annotation for doing OR queries
#### FDI-224
Added calls to safely compare Number objects
#### FDI-256
Moved cleaner interface to common from FDI

## 1.0.12
##### 06-15-2024
#### SU-15 
Added LoginResult from FDI
#### SU-25
Added annotation to skip copying an attribute if it is null
#### SU-26
Building Predicate from a SearchCritera object via reflection
#### FDI-208
Created a custom LinkedHashMap type that has a maximum size limit. This will be used in caches that we don't want to grow too large
#### FDI-213
Added an error for when update a password and they don't match
#### FDI-214
Moved classes that should have been in the security project

## 1.0.11
##### 06-05-2024
#### SU-22
Moved tested validation framework from FDI and cleaned out old code that didn't remained usable

## 1.0.10
##### 06-01-2024
#### SU-24
Added iLike searching with Criteria objects

## 1.0.9
##### 06-01-2024
#### SU-23
Added REVIEWED status to EditStatus

## 1.0.8
##### 05-29-2024
#### SU-19
Migrated code that originated from FDI work
#### FDI-124
Added call to get the current year as well as other calls related to that

## 1.0.7
##### 05-24-2024
#### SU-16
Fixed StringEnum to make sense. getValue should have been getDescription all along
#### SU-17
Added EditStatus enum
#### FDI-84
- Added isActive as a default for StringEnum. This allow for them to be flagged as inactive. See NFLTeam for implementation
- Added isPrivate as a default for StringEnum. This allow for them to be flagged as private and not sent to UIs

## 1.0.6
##### 05-21-2024
#### FDI-78
Removed Enum serializers that shouldn't have been necessary

## 1.0.5
##### 05-19-2024
#### FDI-66
Added a new ErrorCode for when the user making the request is logged out

## 1.0.4
##### 05-17-2024
#### FDI-57 
Cleaned up ErrorCode. 
Added protected setters to ApiRuntimeException for it's children
Added exception for login issues
Made almost all POM dependencies provided scope because the final application should have to provide them

## 1.0.3
##### 05-14-2024
#### SU-14
Renamed packages to have the general functionality first and Spring second

## 1.0.2
##### 05-08-2024
#### SU-10
Open any text file and convert into a List of Strings

## 1.0.1
##### 05-06-2024
#### SU-7
Bug fixes found post-merge
Moved import results into it's own package
Created an object to hold year data in the results

## 1.0.0
##### 05-04-2024
#### SU-5
Finished migration of code from JavaUtil and FileUtil
Added in the Jackson and Swagger dependent classes
Migrated most of the code from Football Importer to this

## 0.0.1
##### 05-03-2024
#### SU-1
Initial project creation
#### SU-5
Initial migration and re-packaging

-----------------------------
